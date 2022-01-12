import Controller from '@ember/controller';
import {action, computed} from '@ember/object'

export default class CoursesEditCoursesController extends Controller {

  @computed('model.name', 'model.room')
  get validForm() {
    if (!this.model.name || !this.model.room) {
      return true
    } else {
      return false
    }
  }

  @action
  update() {
    this.model.save();
    console.log('Actualizando...')
    this.transitionToRoute('courses')
  }
}
