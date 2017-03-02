xquery version "3.0";

declare variable $id as xs:string external;

for $e in doc("Abedemon.xml")//especie
let $tipos := string-join($e/tipo, ', ')
where $e/@id = $id
return  <html>
            <head></head>
            <body>
                <h1> {data($e/nombre)} </h1>
                <img src="{data($e/url)}"/>
                <p> {data($e/descripcion)} </p>
                <p><b>Tipos:</b>{$tipos}</p>
                <p><b>Ataques: </b> 
                        {
                            for $a in $e/ataques
                            let $ataquesOrdenados := doc("Abedemon.xml")//ataque[@id = $e/ataques/tiene-ataque/@id]
                            order by $a/nombre
                            return string-join($ataquesOrdenados, ', ')
                        } 
                </p>
                <p><b>Evoluciones: </b>
                    <ul>
                    {
                        for $evo in $e//evoluciones/especie  
                        return <li><a href="{data($evo/@id)}"> {data($evo/nombre)} </a></li>
                    }
                    </ul>
                </p>
            </body>
        </html> 
        