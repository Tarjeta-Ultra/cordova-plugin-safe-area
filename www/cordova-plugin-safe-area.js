const exec = require('cordova/exec');

function getSafeAreaInsets(success, error) {
  exec(success, error, 'SafeArea', 'getSafeAreaInsets', []);
  return true;
}

function getSystemDimensions(success, error) {
  exec(success, error, 'SafeArea', 'getSystemDimensions', []);
  return true;
}

module.exports = {
  getSafeAreaInsets,
  getSystemDimensions,
};
