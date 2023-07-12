import { RSocketConnector } from "rsocket-core";
import { TcpClientTransport } from "rsocket-tcp-client";

const connector = new RSocketConnector({
  transport: new TcpClientTransport({
    connectionOptions: {
      host: "127.0.0.1",
      port: 9090,
    },
  }),
});

const rsocket = await connector.connect();

rsocket.requestResponse(
  {
    data: Buffer.from("Hello World"),
  },
  {
    onError: (e) => {
      console.error(e);
    },
    onNext: (payload, isComplete) => {
      console.log(
        `payload[data: ${payload.data}; metadata: ${payload.metadata}]|${isComplete}`
      );
    },
    onComplete: () => { },
    onExtension: () => { },
  }
);
