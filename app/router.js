import EmberRouter from '@ember/routing/router';
import config from 'ember-practice/config/environment';

export default class Router extends EmberRouter {
  location = config.locationType;
  rootURL = config.rootURL;
}

Router.map(function() {
  this.route('students');
  this.route('add-student');
  this.route('courses', function() {
    this.route('add-courses');
    this.route('edit-courses', { path: '/edit-courses/:id' });
  });
});
