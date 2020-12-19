grammar Alimentos;

archivo: persona platos;
persona: nombre ',' edad ',' peso ',' altura ',' genero ;
edad: INT ;
peso: FLOAT;
genero: TEXTO ;
altura: FLOAT;

platos: desayuno comida cena;
desayuno : tipoPlato alimento+;
comida : tipoPlato alimento+;
cena : tipoPlato alimento+;
tipoPlato : 'DESAYUNO'| 'COMIDA'| 'CENA';

alimento: (cantidad ',' nombre ',' tipo ',' peso_alimento ',' calorias ',' proteinas ',' lipidos ',' carbohidratos );
cantidad:  FLOAT | gramos;
gramos : FLOAT GRAMOS;
nombre : TEXTO (' ' TEXTO)*;
tipo: TEXTO (' ' TEXTO)*;
peso_alimento: FLOAT;
calorias: FLOAT;
proteinas: FLOAT;
lipidos: FLOAT;
carbohidratos: FLOAT;


//--tokens--
INT: [0-9]+;
FLOAT
 : [0-9]+ '.' {_input.LA(1) != '.'}?
 | [0-9]* '.' [0-9]+
 ;

GRAMOS: 'gr';
TEXTO :  ~[ ,\t\r\n0-9]+;
IGNORAR:   [ \t\r\n]+ -> skip;
