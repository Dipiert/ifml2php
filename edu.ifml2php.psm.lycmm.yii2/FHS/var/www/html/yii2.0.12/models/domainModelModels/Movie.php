<?php

namespace app\models\domainModelModels;
use Yii;		
use yii\base\Model;
use yii\db\ActiveRecord;

class Movie extends ActiveRecord
{

public function rules()
{
	return [
             [[], 'required']
 		   ];
}

public static function tableName()
{
    return 'movie';
}

public function attributeLabels()
{
        return [
        	   ];
}


}
