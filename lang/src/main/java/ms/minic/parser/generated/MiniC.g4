grammar MiniC;

@header {
    package ms.minic.parser.generated;
}

mc : 'void' 'main' '(' ')' '{' varDecl? statSeq '}' ;

varDecl : 'int' IDENT ( ',' IDENT )* ';' ;
statSeq : stat* ;

stat : (assign | print)? ';' ;
assign : IDENT '=' expr ;
print : 'printf' '(' expr ')' ;

expr: expr op=('*'|'/') expr # MulDiv
    | expr op=('+'|'-') expr # AddSub
    | NUMBER # Number
    | IDENT # Ident
    | '('expr')' # Parens
    ;

IDENT : ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')* ;
NUMBER : [0-9]+ ;
ADD: '+' ;
SUB: '-' ;
MUL: '*' ;
DIV: '/' ;

WS : [ \t\r\n] -> skip ;
