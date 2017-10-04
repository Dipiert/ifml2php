# ifml2php
## From [IFML](http://www.ifml.org/) Models to PHP frameworks [Yii2](http://www.yiiframework.com/) and [Laravel](https://laravel.com/). A set of transformations using [ATL](https://eclipse.org/atl/), [Acceleo](https://www.eclipse.org/acceleo/) and Java.

A practical implementation of the achievements of models integration it's not possible if a suitable set of tools doesn't exist to facilitate the application of models, techniques, transformations and maintenance of the coherence of the models in order to achieve, in the end, executable code.
This project intended to facilitate the adoption of the MDD approach by Web Developers meeting their needs and current trends.


### Related Links
* [Eclipse Luna](https://eclipse.org/luna/)
* [IFML Editor](https://github.com/ifml/ifml-editor)
* [Sirius](https://eclipse.org/sirius/)
* [Un caso de estudio sobre la aplicación de UWE para la generación de sistemas web](https://goo.gl/dozG7N)

-----------------------------------------------------------------------------------------------------------------------------------
Fork this repo.

Prepara el entorno de desarrollo:

Requerimientos

Eclipse Luna Modeling Tools
https://www.eclipse.org/downloads/packages/eclipse-modeling-tools/lunasr2

Help -> Installing Modelling Components:
Seleccionar Acceleo y ATL. Se te pedirá que reinicies Eclipse para que los cambios tengan lugar. Hazlo

Importar tu fork como proyecto de GitHub.

Crea un nuevo proyecto ATL.

En nuestro repo, el proyecto ATL se llama edu.ifml2php.pim.ifml.gen.lycmm. Respeta la convención para plugins de Eclipse
"lycmm" pretende significar "Laravel, Yii2 & CodeIgniter Meta-Model"

<domain><project name (optional)><kind of input (optional)><input metamodel name>gen<output language name>

El proyecto ATL está compuesto por:
-Un archivo ifml2OurMM.atl, en donde están todas las reglas de transformacion M2M.
-Una carpeta atlLibraries, donde se guardan los helpers utilizados por el archivo ifml2OurMM.atl

Para correr las transformaciones debes asegurarte de tener el archivo ifml2OurMM.launch en la raiz del proyecto ATL. Haz click derecho sobre el archivo ifml2OurMM.atl. Luego en "Run As" -> "ATL Transformation".
En caso de que no tengas dicho archivo .launch o que tengas problemas al correr la transformación deberás setear los sgtes. parámetros haciendo click derecho sobre el archivo ifml2OurMM.atl. Luego en "Run As" -> "ATL Transformation".

Metamodelos de entrada: se recomienda siempre usar namespaces más que paths relativos o absolutos. En nuestro caso los metamodelos son:
IFMLMM
extMM
ourMM

Modelos de entrada: son de dominio y de flujos de interacción (core y ext). En el caso de los 2 últimos, uno debería indicar el mismo .core (para aprender a generar un archivo .core, ver Sección "IFMLEditor").

Modelos Destino: básicamente la ruta en donde se guardará el .xmi generado.

Librerías: no hace falta más que incluir el path de cada librería según su nombre.

Si la transformación se ejecutó correctamente deberías tener un archivo .xmi en la ruta que especificaste en el Launch Wizard.

Crea un nuevo proyecto Acceleo:

Necesitas indicar la URI de los metamodelos con los que trabajarás en este proyecto. En este caso será solo uno y será el que estuviera seteado en el archivo Metamodel.ecore en el momento de su registro EMF. ¿Qué? Los metamodelos deben registrar la URI que utilizarán, para ello, lo más sencillo es cambiar la perspectiva de Eclipse a ATL, luego hacer click derecho sobre el metamodelo a registrar y darle a "Register Metamodel". No esperes confirmación o cambio alguno, pero el metamodelo estará registrado. A la hora de incluirlo en el proyecto Acceleo, te aparece como "Runtime Version" y no como "Development Version" no hay problemas con eso.
