<?php

namespace app\controllers\domainModelControllers;
use Yii;
use yii\web\Controller;
use yii\db\Connection;
use app\models\domainModelModels\Movie;

class MovieController extends Controller
{

   function actionAddMovie()
   {
      $request = Yii::$app->request;
      $post = $request->post();   
      $post['director'] = implode($post['director'], ', ');
      $movie = new Movie();
      $movie->setAttributes($post);
      $movie->save(false);
   }

   function actionUpdateMovie()
   {        
      $request = Yii::$app->request;
      $post = $request->post();
      $id = $post['id'];   
      $post['director'] = implode($post['director'], ', ');
      $movie = Movie::findOne($id);
      $movie->setAttributes($post);
      $movie->update();
   }

   function actionDeleteMovie()
   {   
     $request = Yii::$app->request; 
     $post = $request->post();
     $id = $post['id'];   
     $movie = Movie::findOne($id);
     $movie->delete();                
   }

   function actionViewListMovie()
   {
        return $this->render('/InteractionFlowModelViews/ListMovie');
   }
   function actionViewMovie()
   {
        return $this->render('/InteractionFlowModelViews/Movie');
   }
   function actionViewAddFormMovie()
   {
        return $this->render('/InteractionFlowModelViews/AddFormMovie');
   }
   function actionViewUpdateFormMovie()
   {
        return $this->render('/InteractionFlowModelViews/UpdateFormMovie');
   }
   function actionViewDeleteFormMovie()
   {
        return $this->render('/InteractionFlowModelViews/DeleteFormMovie');
   }

}
