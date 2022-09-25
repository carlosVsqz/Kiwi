import {combineReducers} from 'redux';
import {commonReducer} from '@store/slices/common';
import {postReducer} from '@store/slices/posts';
import {videoReducer} from '@store/slices/videos';
import {authorReducer} from '@store/slices/author';
import {archiveReducer} from "@store/slices/archive";
import {jobReducer} from "@store/slices/job";

const rootReducer = combineReducers({
  common: commonReducer,
  posts: postReducer,
  video: videoReducer,
  author: authorReducer,
  archives: archiveReducer,
  job: jobReducer,
});

export default rootReducer;
