import { Injectable } from 'vue-property-decorator';
import { RSocketClient, RSocketResumableTransport } from 'rsocket-core';

@Injectable()
export class RSocketService {
private client: RSocketClient;

constructor() {
    // Инициализация RSocket клиента
    const transport = new RSocketResumableTransport({
      // Настройки транспорта
    });
    this.client = new RSocketClient({
      // Настройки клиента
      transport
    });
  }

  // Методы для обмена данными с RSocket сервером
}
