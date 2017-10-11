<?php
use yii\helpers\Url;
use yii\helpers\Html; 
?>
<!DOCTYPE html>
<link rel="stylesheet" type="text/css" href="yii2.0.12/web/css/ifml2php.css /yii2.0.12/web/css/ifml2php.css">
<?= Html::a('Main Menu Movie', Url::to(['movie/view-main-menu-movie']), ['class' => 'ifml2php_navbar']) ?>
<?= Html::a('Add Form Movie', Url::to(['movie/view-add-form-movie']), ['class' => 'ifml2php_navbar']) ?>
<?= Html::a('Delete Form Movie', Url::to(['movie/view-delete-form-movie']), ['class' => 'ifml2php_navbar']) ?>
<?= Html::beginForm(['movie/update-movie'], 'post', ['name' => 'UpdateFormMovie' ]) ?>
<?= Html::input('text', 'title', null, []) ?> 
<?= Html::input('text', 'year', null, []) ?> 
<?= Html::radio('audience', false, ['value' => 'G']) ?> 
<?= Html::radio('audience', false, ['value' => 'PG']) ?> 
<?= Html::radio('audience', false, ['value' => 'PG-13']) ?> 
<?= Html::radio('audience', false, ['value' => 'R']) ?> 
<?= Html::checkbox('saga[]' ,false, ['value' => 'isSaga']) ?>
<?= Html::submitButton('Update Movie', []) ?>
<?= Html::endForm() ?>

