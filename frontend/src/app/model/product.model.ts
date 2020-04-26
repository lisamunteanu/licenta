import {Price} from 'src/app/model/price.model';

export class Product {
  id?: number;
  name?: string;
  brand?: string;
  image?: string;
  description?: string;
  available?: boolean;
  stock?: number;
  price?: Price;

  constructor(
  ) {
  }
}
