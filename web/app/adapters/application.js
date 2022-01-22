import JSONAPIAdapter from '@ember-data/adapter/json-api';

export default class ApplicationAdapter extends JSONAPIAdapter {
  host = "http://localhost:8080"
  headers = {
    'Accept': 'application/json',
    'Content-Type' : 'application/json'
  }
}
