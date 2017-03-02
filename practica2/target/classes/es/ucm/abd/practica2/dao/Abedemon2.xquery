xquery version "3.0";

declare variable $tipo as xs:string external;

for $t in doc("Abedemon.xml")//especie
let $numAtaques := count($t/ataques/tiene-ataque)
where $t/tipo = $tipo
return <resultado id="{data($t/@id)}" nombre="{data($t/nombre)}" num-ataques="{data($numAtaques)}"/>