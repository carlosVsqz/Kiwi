import {ThemeVariation} from '@common/enum';
import {PostItem} from '@store/slices/posts';
import {ArchiveItem} from "@store/slices/archive";

export enum PostInfo {
  User,
  Date,
  Comment,
}
export interface PostProps {
  hideCover?: boolean;
  hideContent?: boolean;
  data: PostItem;
  className?: string;
  theme?: ThemeVariation;
  hideButton?: boolean;
  hideDescription?: boolean;
  hideInfos?: boolean;
  infos?: PostInfo[];
}

export interface ArchiveProps {
  hideCover?: boolean;
  hideContent?: boolean;
  data: ArchiveItem;
  className?: string;
  theme?: ThemeVariation;
  hideButton?: boolean;
  hideDescription?: boolean;
  hideInfos?: boolean;
  infos?: PostInfo[];
}
