import Controller from '@ember/controller';
import { action, computed } from '@ember/object'

export default class CoursesAddCoursesController extends Controller {

    @computed('model.name', 'model.room')
    get validForm() {
      if(!this.model.name || !this.model.room){
        return true
      }else{
        return false
      }
    }

    @action
    save() {
        this.model.save();
        console.log('Creando...')
        this.transitionToRoute('courses')
    }
}
