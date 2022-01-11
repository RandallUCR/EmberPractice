import Route from '@ember/routing/route';

export default class CoursesAddCoursesRoute extends Route {
    model(){
        return this.store.createRecord('course',{name: '', room: ''})
    }
}
