import Component from '@glimmer/component';
import { action } from '@ember/object'

export default class StudentsList extends Component {
    @action
    delete() {
        console.log('Borrando...')
        this.args.student.destroyRecord();
    }
}