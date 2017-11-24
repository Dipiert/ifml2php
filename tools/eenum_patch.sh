#!/bin/bash

# EMF it does not serialize the first one enumeration
# The keepDefault option is not yet supported by ATL.
# That is an ugly patch but is working

usage ()
{
  echo "Usage : $0 <path to metamodel> [<workaround word>]"
  exit
}

if [ "$#" -gt 2 -o -z "$1" ]
then
  usage
fi
MMPATH=$1
WORKAROUND=${2:-workaround}

sed -i "/<eClassifiers xsi:type=\"ecore:EEnum\" name=\"[a-zA-Z]*\">/a <eLiterals name=\"$WORKAROUND\" literal=\"$WORKAROUND\"\/>" $MMPATH


