<!DOCTYPE html>
<head>
	<meta name="description" content="ifml2php">
	<meta name="author" content="Damián Rotta">
	<meta name="author" content="Gonzalo Pallotta">
	<meta name="keywords" content="IFML, PHP, MDA, MDWE">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	{{ Html::style('css/ifml2php.css') }}
	<title>UpdateFormMovie</title>
	<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">	
	
</head>
<body>
<a href="{{ route('movie.MainMenuMovie') }}" target="self" class="navbar"> Main Menu Movie </a> 
<a href="{{ route('movie.AddFormMovie') }}" target="self" class="navbar"> Add Form Movie </a> 
<a href="{{ route('movie.DeleteFormMovie') }}" target="self" class="navbar"> Delete Form Movie </a> 
									
<div class="form">
{!! Form::open(['action' => 'domainModelControllers\MovieController@updateFormMovie', 'method' => 'post', 'name' => 'UpdateFormMovie' ]) !!}

{!! Html::decode(Form::label('title','&nbsp&nbsp&nbsp&nbspTitle')) !!}

{{ Form::text('title') }}
{!! Html::decode(Form::label('icon','<i class="fa fa-search" aria-hidden="true"></i>')) !!}
<br>

{{ Form::label('year', 'Year') }}
{{ Form::text('year') }}
<br>	
{{ Form::label('G', 'G') }}
{{ Form::radio('audience', 'G') }}

{{ Form::label('PG', 'PG') }}
{{ Form::radio('audience', 'PG') }}

{{ Form::label('PG-13', 'PG-13') }}
{{ Form::radio('audience', 'PG-13') }}

{{ Form::label('R', 'R') }}
{{ Form::radio('audience', 'R') }}

{{ Form::label('isSaga', 'IsSaga') }}
{{ Form::checkbox ('saga[ ]', 'isSaga') }}
<br><br>

{{ Form::submit('Enviar') }}
{!! Form::close() !!}
</div>


