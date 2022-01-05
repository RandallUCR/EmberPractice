import Controller from '@ember/controller';
import { action } from '@ember/object'
import { alias } from '@ember/object/computed';
import { tracked } from '@glimmer/tracking';

export default class ApplicationController extends Controller {
  @tracked
  name = 'Bryan';

  @alias('name')
  sameName;

  @action
  hello() {
    window.alert('Hello')
  }

  @action
  updateName(e) {
    this.name = e.target.value;
  }
}
