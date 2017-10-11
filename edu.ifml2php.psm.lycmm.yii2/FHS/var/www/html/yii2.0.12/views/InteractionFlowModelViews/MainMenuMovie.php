<?php
use yii\helpers\Url;
use yii\helpers\Html; 
?>
<!DOCTYPE html>
<link rel="stylesheet" type="text/css" href="yii2.0.12/web/css/ifml2php.css /yii2.0.12/web/css/ifml2php.css">
<?= Html::a('Add Form Movie', Url::to(['movie/view-add-form-movie']), ['class' => 'ifml2php_navbar']) ?>
<?= Html::a('Update Form Movie', Url::to(['movie/view-update-form-movie']), ['class' => 'ifml2php_navbar']) ?>
<?= Html::a('Delete Form Movie', Url::to(['movie/view-delete-form-movie']), ['class' => 'ifml2php_navbar']) ?>
<?= Html::tag('p', 'Movies DataBase', ['data-language' => 'es', 'id' => 'Title']) ?> 
<?= Html::tag('p', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', ['data-language' => 'es', 'id' => 'Intro']) ?> 
<?= Html::img('https://upload.wikimedia.org/wikipedia/en/4/4e/IFML-Interaction-Flow-Modeling-Language-OMG-logo-copyrighted.png', ['alt' => 'logo']) ?> 

