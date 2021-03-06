const { createProxyMiddleware } = require("http-proxy-middleware");

module.exports = function (app) {
  app.use(
    "/user",
    createProxyMiddleware({
      target: "http://localhost:8080",
    })
  );

  app.use(
    "/api",
    createProxyMiddleware({
      target: "http://localhost:8080",
    })
  );

  app.use(
    "/login/oauth2",
    createProxyMiddleware({
      target: "http://localhost:8080",
    })
  );

  // app.use(
  //   "/oauth2",
  //   createProxyMiddleware({
  //     target: "http://localhost:8080",
  //   })
  // );
};
