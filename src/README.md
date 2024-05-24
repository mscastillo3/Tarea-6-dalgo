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