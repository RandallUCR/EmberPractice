export default function () {

  // These comments are here to help you get started. Feel free to delete them.

  /*
    Config (with defaults).

    Note: these only affect routes defined *after* them!
  */

  // this.urlPrefix = '';    // make this `http://localhost:8080`, for example, if your API is on a different server
  // this.namespace = '';    // make this `/api`, for example, if your API is namespaced
  // this.timing = 400;      // delay for each request, automatically set to 0 during testing

  /*
    Shorthand cheatsheet:

    this.get('/posts');
    this.post('/posts');
    this.get('/posts/:id');
    this.put('/posts/:id'); // or this.patch
    this.del('/posts/:id');

    https://www.ember-cli-mirage.com/docs/route-handlers/shorthands
  */

  this.namespace = ''
  this.get('/courses', () => {
    return {
      data: [
        /*{attributes: {name: 'Algebra', room: 30} , id: 1, type: 'course' },
        { attributes: {name: 'Historia', room: 25}, id: 2, type: 'course'  },
        { attributes: {name: 'Calculo', room: 40}, id: 3, type: 'course'  }*/
      ]
    };
  });

  this.get("/courses/:id", (schema, request) => {
    let id = request.params.id
  
    return schema.courses.find(id)
  });

  this.post('/courses', (schema, request) => {
    let attr = JSON.parse(request.requestBody);
  
    return schema.courses.create(attr);
  });
}
