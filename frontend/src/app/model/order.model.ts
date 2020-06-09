import * as moment from 'moment';
export class Order {
  id?: number;
  date: moment.Moment;
  deliveryMode?: string;
  paymentMode?: string;
  productsTotal?: number;
  totalDiscount?: number;
  deliveryCost?: number;
  totalPrice: number;

  constructor() {
  }
}
