import { module, test } from 'qunit';
import { setupTest } from 'ember-qunit';

module('Unit | Route | route-students', function(hooks) {
  setupTest(hooks);

  test('it exists', function(assert) {
    let route = this.owner.lookup('route:route-students');
    assert.ok(route);
  });
});
