xquery version "3.0";

declare variable $yoId as xs:string external;
declare variable $adversarioId as xs:string external;

let $idMisAtaques := doc("Abedemon.xml")//especie[@id = $yoId]/ataques/tiene-ataque/@id
let $tiposAdversario := doc("Abedemon.xml")//especie[@id = $adversarioId]/tipo
let $ataques := doc("Abedemon.xml")//ataque[@id = $idMisAtaques]
   
return max($ataques/daño[@tipo = $tiposAdversario]/@valor)