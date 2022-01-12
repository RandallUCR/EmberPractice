import Controller from '@ember/controller';
import { action } from '@ember/object'

export default class CoursesAddCoursesController extends Controller {
    
    willDestroy(){
        if(this.model.hasDirtyAttributes) { 
            this.model.destroyRecord(); 
        }
    }

    @action
    save() {
        this.model.save();
        console.log('Creando...')
        this.transitionToRoute('courses')
    }
}
