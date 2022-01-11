import Controller from '@ember/controller';
import { action } from '@ember/object'

export default class CoursesController extends Controller {
    @action
    delete(id) {
        let del = this.store.peekRecord('course', id);
        del.destroyRecord();
    }
}
