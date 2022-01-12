import Controller from '@ember/controller';
import {action} from '@ember/object'

export default class CoursesIndexController extends Controller {

  willDestroy() {
    if (this.model.hasDirtyAttributes) {
      this.model.destroyRecord();
      return true
    }
    return false
  }

  @action
  delete(course) {
    course.destroyRecord();
  }
}
