# ifml2php
## From [IFML](http://www.ifml.org/) Models to PHP frameworks [Yii2](http://www.yiiframework.com/) and [Laravel](https://laravel.com/). A set of transformations using [ATL](https://eclipse.org/atl/), [Acceleo](https://www.eclipse.org/acceleo/) and Java.

A practical implementation of the achievements of models integration it's not possible if a suitable set of tools doesn't exist to facilitate the application of models, techniques, transformations and maintenance of the coherence of the models in order to achieve, in the end, executable code.
This project intended to facilitate the adoption of the MDD approach by Web Developers meeting their needs and current trends.


### Related Links
* [Eclipse Luna](https://eclipse.org/luna/)
* [IFML Editor](https://github.com/ifml/ifml-editor)
* [Sirius](https://eclipse.org/sirius/)
* [Un caso de estudio sobre la aplicación de UWE para la generación de sistemas web](https://goo.gl/dozG7N)

## Setting up your development environment

### Requirements

 * [Eclipse Luna Modeling Tools](https://www.eclipse.org/downloads/packages/eclipse-modeling-tools/lunasr2)
 * [Composer](https://getcomposer.org/download/)
 * [Apache Commons Lang](https://commons.apache.org/proper/commons-lang/)
 * [Laravel Framework](https://laravel.com/)
 * [Laravel Colletive](https://laravelcollective.com/docs/5.0/html)

#### [Eclipse](https://www.eclipse.org/downloads/packages/eclipse-modeling-tools/lunasr2)

The [Acceleo](https://www.eclipse.org/acceleo/) and [ATL](https://eclipse.org/atl/) frameworks designed for Model-to-Text and Model-Transformation aiding. And we will use them along the project.

Once Eclipse is ready we need to install the Acceleo and ATL Frameworks.
We can do this by opening Eclipse and going to:

 1) Help -> Installing Modelling Components
 2) Choose Acceleo y ATL.
 3) After install you will be prompted to restart Eclipse, do it.

Once Eclipse starts again we need to install the [IFML Editor](https://github.com/ifml/ifml-editor), in order to do that we can follow the instructions [here](http://ifml.github.io/).

This should leave us with a starting working environment.

## Proyects
### ATL Project

First things first, you should import the ATL project in Eclipse:

 1) File -> Import (Alt + F + I)
 2) General
 3) Existing project into workspace

In this repo, the ATL project is called **`edu.ifml2php.pim.ifml.gen.lycmm`**.

This name follow the following convention:

`<domain>.<project-name>.<input-metamodel-name>.gen.<output-language-name>`

**`lycmm`** means "Laravel, Yii2 & CodeIgniter Meta-Model".

The ATL project consists in:

- A file called **ifml2OurMM.atl**, where the Model-To-Model (M2M) transformation rules lives.
- A folder called **atlLibraries**, where the IFML helpers live.

The **ifml2OurMM.launch** file on the ATL project's root contains run configuration parameters. You shouldn't need to change that file but in case you want to know the details about this file go to [Making a .launch file](#launch) section on this README.

Finally, right click in **ifml2OurMM.atl** file, then "Run As" -> "ATL Transformation" should do the trick.

If the transformation was successful you should see a file called **preProd-gen.xmi** (or the name you've set it to in the .launch file) on the ATL project's root.

#### <a name="launch"></a> Making a .launch file.

Right click in  **ifml2OurMM.atl** file, then "Run As" -> "Run Configuration". This opens a window where you can set the following parameters:

(We encourage the use of URIs instead absolute paths or relative paths whenever possible)

ATL Module: This should point to the path of the ifml2OutMM.atl file you've just right-clicked on.

##### Metamodels:

Name| Path |URI
---| --- |---
UMLMM | | uri:http://www.eclipse.org/uml2/5.0.0/UML
IFMLMM | /models/metamodels/IFML-Metamodel.ecore | uri:http://www.omg.org/spec/20130218/core
extMM | /models/metamodels/IFML-Metamodel.ecore | uri:http://www.omg.org/spec/20130218/ext
ourMM | /edu.ifml2php.pim.ifml.gen.lycmm/models/metamodels/Metamodel.ecore  | uri:http://www.application.org

***Do not check the `Is Metametamodel` check box***

##### Source Models:

Name | Conforms to | Path | Type
--- | --- | --- | ---
uml |UMLMMM | /edu.ifml2php.pim.ifml.gen.lycmm/models/models/model.uml | Domain
ifml | IFMLMM | /edu.ifml2php.pim.ifml.gen.lycmm/models/models/movies.core | Interaction Flow
extm | extMM | /edu.ifml2php.pim.ifml.gen.lycmm/models/models/movies.core | Interaction Flow

##### Target models:

ourm: This is the path where the generated .xmi file will be stored. In this case, the ATL project's root.

##### Libraries:


| Name | Path |
| --- | --- |
| ifmlCoreLibrary | /edu.ifml2php.pim.ifml.gen.lycmm/atlLibraries/ifmlCoreLibrary.asm |
| ifmlExtLibrary | /edu.ifml2php.pim.ifml.gen.lycmm/atlLibraries/ifmlExtLibrary.asm |
| mvcLibrary | /edu.ifml2php.pim.ifml.gen.lycmm/atlLibraries/mvcLibrary.asm |
| systemLibrary | /edu.ifml2php.pim.ifml.gen.lycmm/atlLibraries/systemLibrary.asm |


#### Acceleo project

You need to include **Metamodel.ecore** to EMF registry. The easiest way to do that is:

1. Open ATL Perspective
Window->Open Perspective->Other->ATL

2. Register metamodel
Right click on **Metamodel.ecore** -> Register Metamodel.
You will not see any visual change but trust me, the metamodel is registered now.

## Troubleshooting

###ATL
- You must specify a path for *
- Arguments of a generation cannot be null
- {.asm, .atl} does not exist
Verify the M2M transformations parameters in the .launch file


###Acceleo
- Package with URI * not found
Do a manual register of the metamodel.
```
URI uri = URI.createFileURI("../edu.ifml2php.pim.ifml.gen.lycmm/models/metamodels/Metamodel.ecore");
Resource resource = resourceSet.getResource(uri, true);         
EPackage PHPMVC = (EPackage) resource.getContents().get(0);
List<EPackage> subPackages = PHPMVC.getESubpackages();
for(EPackage subPack : subPackages){
   EPackage.Registry.INSTANCE.put(subPack.getNsURI(), subPack);
}
```
- ClassNotFoundException: org.eclipse.uml2.types.TypesPackage
Add [org.eclipse.uml2.types](http://central.maven.org/maven2/org/eclipse/uml2/types/2.0.0-v20140602-0749/types-2.0.0-v20140602-0749.jar) to the classpath.

- Could not find public template * in module *
Add the @main annotation to the corresponding template and make sure you have at least one public template.

- java.lang.NoClassDefFoundError: org/eclipse/core/resources/IresourceChangeListener
Add [org.eclipse.core.resources3.9.1.v20140825-1431.jar](http://central.maven.org/maven2/org/eclipse/birt/runtime/org.eclipse.core.resources/3.9.1.v20140825-1431/org.eclipse.core.resources-3.9.1.v20140825-1431.jar) to the classpath.