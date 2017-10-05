# ifml2php
## From [IFML](http://www.ifml.org/) Models to PHP frameworks [Yii2](http://www.yiiframework.com/) and [Laravel](https://laravel.com/). A set of transformations using [ATL](https://eclipse.org/atl/), [Acceleo](https://www.eclipse.org/acceleo/) and Java.

A practical implementation of the achievements of models integration it's not possible if a suitable set of tools doesn't exist to facilitate the application of models, techniques, transformations and maintenance of the coherence of the models in order to achieve, in the end, executable code.
This project intended to facilitate the adoption of the MDD approach by Web Developers meeting their needs and current trends.


### Related Links
* [Eclipse Luna](https://eclipse.org/luna/)
* [IFML Editor](https://github.com/ifml/ifml-editor)
* [Sirius](https://eclipse.org/sirius/)
* [Un caso de estudio sobre la aplicación de UWE para la generación de sistemas web](https://goo.gl/dozG7N)

---------------------------------------------------------------------------------------------------------------------------------### Setting up your development environment

#### Requirements
[Eclipse Luna Modeling Tools](https://www.eclipse.org/downloads/packages/eclipse-modeling-tools/lunasr2)

After download Eclipse, open it up and go to: 
Help -> Installing Modelling Components

Choose Acceleo y ATL. After install you will be prompted to restart Eclipse, do it.

#### ATL project

Create a new ATL project in Eclipse:

New -> Other...-> ATL Project

In this repo, the ATL project is called
```
edu.ifml2php.pim.ifml.gen.lycmm 
```
This name follow the following convention:
```
<domain>.<project-name>.<input-metamodel-name>.gen.<output-language-name>
```
"lycmm" means "Laravel, Yii2 & CodeIgniter Meta-Model".

The ATL project consists in:

- A file called **ifml2OurMM.atl** , where the Model-To-Model (M2M) transformation rules lives.
- A folder called **atlLibraries**, where the helpers lives.

In order to run the M2M transformations you need to have the **ifml2OurMM.launch** file on the ATL project's root.
This file contain run configuration parameters, in case you want to know the details about this file go to "Making a .launch file" section on this README.

Finally, right click in **ifml2OurMM.atl** file, then "Run As" -> "ATL Transformation" should do the magic.

If the transformation was succesful you should see a file called **preProd-gen.xmi** (or the name you've set) on the ATL project's root.

##### Making a .launch file
Right click in  **ifml2OurMM.atl** file, then "Run As" -> "Run Configuration". This open a window where you can set the following parameters:

(We encourage the use of URIs instead absolute paths or relative paths whenever it is possible)

Source Metamodels: In this case,

Name | Path | URI
-- | -- | --
IFMLMM |/models/metamodels/IFML-Metamodel.ecore | http://www.omg.org/spec/20130218/core
extMM | /models/metamodels/IFML-Metamodel.ecore |http://www.omg.org/spec/20130218/ext
PHPMVC | /models/metamodels/Metamodel.ecore  | http://www.application.org

Source Models: in this case,

Name | Conforms to | Path | Type
-- | -- | -- | --
uml |UMLMMM | /models/models/model.uml | Domain
ifml | IFMLMM | /models/models/movies.core | Interaction Flow
extm | extMM | /models/models/movies.core | Interaction Flow

Target models: the path where the generated .xmi file will be stored. In this case, the ATL project's root.

Libraries: In this case,

- ifmlCoreLibrary.asm
- ifmlExtLibrary.asm
- mvcLibrary.asm
- systemLibrary.asm

#### Acceleo project

You need to include **Metamodel.ecore** to EMF registry. The easiest way to do that is:

1. Open ATL Perspective
Window->Open Perspective->Other->ATL

2. Register metamodel
Right click on **Metamodel.ecore** -> Register Metamodel.
You will not see any visual change but trust me, the metamodel is registered now.

Now, let's to create a new Acceleo project in Eclipse:

New -> Other...-> Acceleo Project

In this repo, there is an Acceleo project for each Target framework:
```
edu.ifml2php.psm.lycmm.gen.laravel
edu.ifml2php.psm.lycmm.gen.yii2
```

During the Acceleo project creation you need to indicate the URI of the metamodel that you just registered. That will be in _Runtime Version_ list.
