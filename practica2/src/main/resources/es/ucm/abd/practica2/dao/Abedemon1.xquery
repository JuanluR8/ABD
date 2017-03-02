xquery version "3.0";

distinct-values(for $t in doc("Abedemon.xml")//especie
return data($t/tipo))