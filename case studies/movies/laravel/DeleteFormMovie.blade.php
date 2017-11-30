<!DOCTYPE html>
<head>
	<meta name="description" content="ifml2php">
	<meta name="author" content="Damián Rotta">
	<meta name="author" content="Gonzalo Pallotta">
	<meta name="keywords" content="IFML, PHP, MDA, MDWE">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	{{ Html::style('css/ifml2php.css') }}
	<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">	
	<title>DeleteFormMovie</title>
</head>
<body>
<a href="{{ route('movie.MainMenuMovie') }}" target="self" class="navbar"> Main Menu Movie </a> 
<a href="{{ route('movie.AddFormMovie') }}" target="self" class="navbar"> Add Form Movie </a> 
<a href="{{ route('movie.UpdateFormMovie') }}" target="self" class="navbar"> Update Form Movie </a> 
									
<div class="form">
{!! Form::open(['action' => 'domainModelControllers\MovieController@deleteMovieForm', 'method' => 'post', 'name' => 'DeleteMovieForm' ]) !!}

{!! Html::decode(Form::label('title','Title')) !!}
{{ Form::text('title') }}
{!! Html::decode(Form::label('icon','<i class="fa fa-search" aria-hidden="true"></i>')) !!}
<br>	

{{ Form::submit('Enviar') }}
{!! Form::close() !!}
</div>


