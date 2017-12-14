<?php
namespace Movies\Http\Requests\domainModelRequests;

use Illuminate\Foundation\Http\FormRequest;

class MovieRequest extends FormRequest
{
    /**
     * Determine if the user is authorized to make this request.
     *
     * @return bool
     */
    public function authorize()
    {
        return true;
    }

    /**
     * Get the validation rules that apply to the request.
     *
     * @return array
     */
    public function rules()
    {
        return [
            'title' => ['required', 'regex:/[a-zA-Z|áéíóú|\(\)|-|\d]+/'],
            'year' => ['regex:/[12][0-9]{3,3}/'],
            'audience' => ['regex:/[G|PG|PG\-13|R]/'],
            'isSaga' => ['regex:/[01]{1}/'],
        ];
    } 

    public function messages() {
        return [
            'title.required' => 'El título de la película es un campo requerido.',
            'title.regex' => 'El título debe estar compuesto por letras minúsculas o mayúsculas, guiones, parentesis.',
            'year.required' => 'El año de estreno de la película es un campo requerido.',
            'year.regex' => 'El año de estreno debe estar compuesto por 4 dígitos y comenzar con un 1 o un 2',
            'audience.required' => 'La audiencia es un campo requerido.',
            'audience.regex' => 'Los valores permitidos para la audiencia son G, PG, PG-13 y R.',
            'isSaga.regex' => 'El campo \'isSaga\' no es válido.',
            'title.unique' => 'deberia ser unico'          
        ];
    }
}