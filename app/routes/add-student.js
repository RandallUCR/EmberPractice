import Route from '@ember/routing/route';

export default class AddStudentRoute extends Route {
    model(){
        return this.store.createRecord('student',{name: ''})
    }
}
