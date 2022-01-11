import Route from '@ember/routing/route';

export default class CoursesEditCoursesRoute extends Route {
    model(params) {
        this.store.findRecord('course', params.id);
    }
}
