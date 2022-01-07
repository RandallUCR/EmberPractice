import Controller from '@ember/controller';
import { action } from '@ember/object'

export default class AddStudentController extends Controller {
    @action
    save(){
        //this.model.save();
        console.log('Creando...')
        this.transitionToRoute('students')
    }
}
