module.exports = {
  presets: [
    '@babel/preset-env',
    '@babel/preset-typescript',
    '@vue/cli-plugin-babel/preset'
  ],
  plugins: [
    ['@babel/plugin-proposal-decorators', { legacy: true }],
    ['@babel/plugin-proposal-class-properties', { loose: true }]
  ]
};
