import Controller from '@ember/controller';
import { action } from '@ember/object'

export default class CoursesIndexController extends Controller {
    @action
    delete(course) {
        course.destroyRecord();
    }
}
