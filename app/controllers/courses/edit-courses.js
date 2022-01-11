import Controller from '@ember/controller';
import { action } from '@ember/object'

export default class CoursesEditCoursesController extends Controller {
    @action
    update() {
        this.model.save();
        console.log('Actualizando...')
        this.transitionToRoute('courses')
    }
}
