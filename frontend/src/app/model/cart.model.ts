import {CartEntry} from './cartEntry.model';

export class Cart{
  id?: number;
  userId?: number;
  cartEntries?: CartEntry[];

  constructor() {
  }
}
