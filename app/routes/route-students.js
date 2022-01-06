import Route from '@ember/routing/route';

export default class RouteStudentsRoute extends Route {
    model() {
        /*return [
            { name: 'Randall', id: 'B61776' },
            { name: 'Maria', id: 'B81930' },
            { name: 'Laura', id: 'B74903' }
        ]*/
        return this.store.peekAll('student');
    }
}
