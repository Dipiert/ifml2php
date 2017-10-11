<?php
use yii\helpers\Url;
use yii\helpers\Html; 
?>
<!DOCTYPE html>
<link rel="stylesheet" type="text/css" href="yii2.0.12/web/css/ifml2php.css /yii2.0.12/web/css/ifml2php.css">
<?= Html::a('Main Menu Movie', Url::to(['movie/view-main-menu-movie']), ['class' => 'ifml2php_navbar']) ?>
<?= Html::a('Add Form Movie', Url::to(['movie/view-add-form-movie']), ['class' => 'ifml2php_navbar']) ?>
<?= Html::a('Update Form Movie', Url::to(['movie/view-update-form-movie']), ['class' => 'ifml2php_navbar']) ?>
<?= Html::beginForm(['movie/delete-movie'], 'post', ['name' => 'DeleteMovieForm' ]) ?>
<?= Html::input('text', 'title', null, []) ?> 
<?= Html::submitButton('Delete Movie', []) ?>
<?= Html::endForm() ?>

