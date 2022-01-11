import Route from '@ember/routing/route';

export default class CoursesRoute extends Route {
    model(){
        return this.store.findAll('course')
    }
}
