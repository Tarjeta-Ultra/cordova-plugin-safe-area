> [!NOTE]
> Fork from https://github.com/sortiz4/cordova-plugin-safe-area.git (unavailable now)

# Safe Area
This plugin allows developers to collect safe area dimensions such as status
bar height, navigation bar height, and insets for displays with cutouts. This
can be used to create an edge-to-edge experience on devices.

## Platforms
The following platforms are supported.

- Android

## Installation
This plugin requires AndroidX and Kotlin.

```sh
cordova plugin add https://github.com/Tarjeta-Ultra/cordova-plugin-safe-area.git
```

## Functions
The following functions will be attached to `cordova.plugins.SafeArea`. Please
note that the units of the dimensions are in physical pixels and may need to be
normalized.

```typescript
declare interface SafeAreaInsets {
  top: number;
  bottom: number;
  left: number;
  right: number;
}

declare interface SystemDimensions {
  statusBarHeight: number;
  navigationBarHeight: number;
}

declare function getSafeAreaInsets(success: (_: SafeAreaInsets) => void, error: (_: string) => void): boolean;
declare function getSystemDimensions(success: (_: SystemDimensions) => void, error: (_: string) => void): boolean;
```
