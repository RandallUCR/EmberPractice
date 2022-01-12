import Route from '@ember/routing/route';

export default class CoursesEditCoursesRoute extends Route {
    model(params) {
        return this.store.peekRecord('course', params.id);
    }
}
