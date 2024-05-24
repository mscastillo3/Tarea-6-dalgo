ALGORITMO DE VERIFICACION PUNTO UNO:

La primera linea son los nombres de todas las calles separadas por espacio.

la segunda linea es la colucion que se quiere verificar.

la tercera es el la cota minima que se quiere verificar.

la quinta es la cantidad de intercecciones.

las siguentes son las calles qeu se unen entre si en una misma interseccion

ejemplo:

nombre de las calles --> Juan caicedo julieta clle80 suba primera septiama

solucion a verificar --> 0 1 4 5

cota maxima --> 4

numero de intercecciones --> 6

calles que se inetrsecan 

1 2 3

2 3 4

1 6

6 5

0 6 3

5 6 

las calles uno dos y tres comparten la misma interseccion.



ALGORITMO DE VERIFICACION PUNTO DOS:

La primera linea son los dias que se pueden dar las clases separados por espacio.

la segunda liena son los nombres de los estudiantes que se postularon.

la tersera linea es la cota o sea el numero minimo de clases.

la cuarta linea son los dias que se quieren verificar si es una solucion y estan separados por espacio.

las siguintes lineas son los indices del estudiantes segun las clases que puede tomar 

ejemplo: 

dias --> 5 6 7 10 20 18 17

estudiantes --> Juan Julian Juana Gillermo Jeronimo Julieta Maria Ana Natalia Santiago Miguel Nicolas

cota --> 3

dias ravisar --> 6 7 20

estudiantes que pueden dia uno --> 1 2 3

1 2 4 5

0 9 11

8 7

3 6 7 8 10 11

1 4

solo se ponen los numeros


ALGORITMO DE APROXIMACIÓN PUNTO 3:

Recibe entradas por standard input de la forma:
-----------------------------------------------------------------
a b c d e f g
a b
c d
d e
f g


------------------------------------------------------------------
donde la primera linea se declaran todos los amigos del conjunto A como strings separadas por 1 espacio, posteriormente
se declaran en las siguientes líneas cada pelea entre 2 amigos (tienen que ya haber sido declarados en la primera línea para
que sea válido). Para que el programa sepa como acabar, es necesario que se dejen 2 lineas en blanco después de la última pelea.
el programa recibirá estas entradas y hará print de los amigos que deben estar en el primer conjunto para maximizar el número
de peleados separados en los 2 conjuntos. 
La metodología de este algoritmo es partir aleatoriamente el conjunto de todos los amigos en 2 conjuntos, y luego iterar sobre cada uno de los amigos del conjunto 1 para ver cuantas peleas tiene con amigos del mismo conjunto y cuantas tiene con amigos del otro,
si hay más peleas internas que externas, se cambia ese amigo al otro conjunto, lo cual estrictamente aumenta el número de peleas 
separadas entre los conjuntos, mejorando la respuesta dada.

BONO:

la primera linea del archivo es la cantidad de calles y la cantidad de intercecciones separadas por un espacio.

las siguentes son las calles qeu se unen entre si en una misma interseccion

ejemplo:

numero de calles, numero de intercecciones--> 7 6

calles que se inetrsecan 

1 2 3

2 3 4

1 6

6 5

0 6 3

5 6 

las calles uno dos y tres comparten la misma interseccion.

