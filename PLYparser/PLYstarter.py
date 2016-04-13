""" This will parse the data from the unix command echo "Header1 is this~Header2 and that~~Data 1.0~Data 2.0" | tr "~" "\n"
which is:
Header1 is this
Header2 and that

Data 1.0
Data 2.0
"""

tokens = ('SUMLEV', 'NAME', 'INTEGER', 'SIGN', 'X')
literals = ['.', ',']

# Tokens
t_SUMLEV  = r'SUMLEV,[ -~]+'
t_NAME    = r'[A-WYZa-z ]+'
t_SIGN    = r'[-]'
t_X       = r'X'

def t_INTEGER(t):
    r'\d+'
    try:
        t.value = int(t.value)
    except ValueError:
        print("Integer value too large %d", t.value)
        t.value = 0
    return t

# Ignored characters
t_ignore = "\r"

def t_newline(t):
    r'\n+'
    t.lexer.lineno += t.value.count("\n")

def t_error(t):
    print("Illegal character '%s'" % t.value[0])
    t.lexer.skip(1)

# Build the lexer
import ply.lex as lex   # ply.lex comes from the ply folder in the PLY download.
lexer = lex.lex()

# Parsing rules

global time_step
time_step = 0

def p_start(t):
    '''start : data
             | SUMLEV

    '''


def p_number(t):
    '''number : INTEGER
              | SIGN INTEGER
              | float
              | SIGN float
              | X'''

    if len(t) > 2:
        t[0] = str(t[1]) + str(t[2])
    else:
        t[0] = str(t[1])
def p_float(t):
    'float : INTEGER "." INTEGER'
    t[0] =  str(t[1]) + str(t[2]) + str(t[3])

def p_data(t):
    'data : number "," number "," number "," number "," NAME "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number "," number'

    # prints the state name 
    print ( str(t[9] + ":").ljust(22) +  str(t[11]).ljust(10))

def p_error(t):
    if t == None:
        print("Syntax error at '%s'" % t)

    else:
        print("Syntax error at '%s'" % t.value)
        print(t.type)

import ply.yacc as yacc   # ply.yacc comes from the ply folder in the PLY download.
parser = yacc.yacc()

while True:
    try:
        s = input('')
    except EOFError:
        break
    parser.parse(s)

# To run the parser do the following in a terminal window: echo "Header1 is this~Header2 and that~~Data 1.0~Data 2.0" | tr "~" "\n" | grep -v '^\s*$' | python PLYstarter.py | sed "s/_~_/ which is a float./"
