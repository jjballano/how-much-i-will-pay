### Cálculo de impuesto para un autónomo en España
(Only usefull for contractors in Spain)

Esto es un API con una sola operación que he preparado para hacer los cálculos de lo que voy a pagar en la próxima declaración de la renta.

Es una aproximación y sólo tiene en cuenta los ingresos y gastos de un autónomo y de momento sólo para Madrid. No se tienen en cuenta hipotecas, beneficios en bolsa, etc.
Si alguien quiere alguna provincia más, sólo tiene que decírmelo o hacer un PR con la tabla de IRPF de la provincia que sea añadida en el application.yml

Esto es un pet project para jugar un poco con lo básico de Micronaut.

Para probarlo, se puede hacer un clone, levantarlo con <code>./gradlew run</code> y lanzar un <code>get</code> a <code>http://localhost:8080/howmuch?city=[CIUDAD]&revenue=[INGRESOS]&expenses=[GASTOS]</code>

También se puede probar en la versión instalada en heroku:

<code>https://jjballano-howmuch.herokuapp.com/howmuch?city=madrid&revenue=5432.10&expenses=123.45</code>

Los ingresos son la suma de todas las facturas sin IVA y sin retención. Los gastos también sin IVA.


